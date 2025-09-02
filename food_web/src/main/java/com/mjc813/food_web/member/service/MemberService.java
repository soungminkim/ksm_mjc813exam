package com.mjc813.food_web.member.service;

import com.mjc813.food_web.common.MyFileUtil;
import com.mjc813.food_web.common.exception.MyDataNotFoundException;
import com.mjc813.food_web.common.exception.MyRequestException;
import com.mjc813.food_web.member.dto.IMember;
import com.mjc813.food_web.member.dto.MemberDto;
import com.mjc813.food_web.member.dto.MemberEntity;
import com.mjc813.food_web.security.dto.SignInRequestDto;
import com.mjc813.food_web.security.mysec.MySecurity;
import com.mjc813.food_web.sendemail.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemberService implements UserDetailsService {
    @Autowired
    private IMemberMybatis mybatisMapper;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private MySecurity mySecurity;

    private MyFileUtil mfu = new MyFileUtil();

    public MemberDto insert(MemberDto dto) {
        if (dto == null) {
            throw new MyRequestException("input data error !");
        }
        dto.setPassword(encoder.encode(dto.getPassword()));
        this.encode(dto);
        this.mybatisMapper.insert(dto);
        return dto;
    }

    public List<MemberDto> findAll() {
        List<MemberDto> all = this.mybatisMapper.findAll();
        return all;
    }

    public MemberDto findById(Long id) {
        if (id == null) {
            throw new MyRequestException("delete id error !");
        }
        MemberDto find = this.mybatisMapper.findById(id);
        if (find == null) {
            throw new MyDataNotFoundException("data can't found !");
        }
        try {
            this.decode(find);
        } catch (Throwable e) {
            log.debug(e.toString());
        }
        return find;
    }

    public MemberDto update(MemberDto dto) {
        if (dto == null || dto.getId() == null) {
            throw new MyRequestException("update data error !");
        }
        this.findById(dto.getId());
        this.encode(dto);
        this.mybatisMapper.update(dto);
        return dto;
    }

    public Boolean deleteById(Long id) {
        if (id == null) {
            throw new MyRequestException("delete id error !");
        }
        this.findById(id);
        this.mybatisMapper.deleteById(id);
        return true;
    }

    public Page<MemberDto> findByUsernameContainsAndNickNameContains(String username, String nickName, String role, Pageable pageable) {
        if (pageable == null) {
            throw new MyRequestException("find pageable error !");
        }
        Long count = this.mybatisMapper.countByUsernameContainsAndNickNameContains(username, nickName, role);
        List<MemberDto> list = this.mybatisMapper.findByUsernameContainsAndNickNameContains(username, nickName, role, pageable);
        return new PageImpl<>(list, pageable, count);
    }

    public MemberDto findByUsername(String username) {
        if (username == null) {
            throw new MyRequestException("username null error !");
        }
        MemberDto find = this.mybatisMapper.findByUsername(username);
        if (find == null) {
            throw new MyDataNotFoundException("username can't found !");
        }
        return find;
    }

    public void changePasswd(MemberDto dto) {
        if ( dto == null ) {
            throw new MyRequestException("dto null error !");
        }
        MemberDto find = this.findByUsername(dto.getUsername());
        if (find == null) {
            throw new MyDataNotFoundException("username can't found !");
        }
        find.setPassword(encoder.encode(dto.getPassword()));
        this.mybatisMapper.changePasswd(find);
    }

    public IMember login(SignInRequestDto signInRequestDto) {
        if ( signInRequestDto == null
                || signInRequestDto.getUsername() == null
                || signInRequestDto.getPassword() == null) {
            throw new MyRequestException("signInRequestDto null error !");
        }
        IMember find = this.findByUsername(signInRequestDto.getUsername());
        if ( find != null && encoder.matches(signInRequestDto.getPassword(), find.getPassword()) ) {
            return find;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findByUsername(username);
    }

    //@Transactional
    public IMember findPassword(MemberDto dto) {
        if (dto == null || dto.getUsername() == null || dto.getNickName() == null || dto.getEmail() == null ) {
            throw new MyRequestException("dto input data null error !");
        }
        List<MemberEntity> list = this.memberRepository.findByUsernameEqualsAndNickNameEquals(dto.getUsername()
                , dto.getNickName());
        if ( list == null || list.isEmpty() ) {
            throw new MyDataNotFoundException("user data can't found !");
        }
        MemberEntity find = (MemberEntity)this.decode(list.getFirst());
        if ( !dto.getEmail().equals(find.getEmail()) ) {
            throw new MyDataNotFoundException("user data can't found !");
        }
        String to = find.getEmail();
        String subject = "FoodWeb homepage send to you about user init password !";
        String newPassword = this.mfu.generateRandomString(10);

        find.setPassword(encoder.encode(newPassword));
        MemberEntity data = (MemberEntity)this.encode(find);
        this.memberRepository.save(data);

        String text = "you can use new password = " + newPassword;
        log.debug(text);
        this.emailService.sendSimpleMail(to, subject, text);
        return find;
    }

    public IMember encode(IMember isrc) {
        if ( isrc == null ) {
            return isrc;
        }
        isrc.setEmail( mySecurity.encode(isrc.getEmail()) );
        isrc.setPhoneNumber( mySecurity.encode(isrc.getPhoneNumber()) );
        return isrc;
    }

    public IMember decode(IMember isrc) {
        if ( isrc == null ) {
            return isrc;
        }
        isrc.setEmail( mySecurity.decode(isrc.getEmail()) );
        isrc.setPhoneNumber( mySecurity.decode(isrc.getPhoneNumber()) );
        return isrc;
    }
}
