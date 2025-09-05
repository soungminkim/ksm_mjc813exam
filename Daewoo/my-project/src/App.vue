<template>
  <div>
    <HelloWorld/>

    <div v-for="item in list" :key ="item">
      {{ item.tile}}
    </div>

  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import axios from 'axios';

export default {

  name: 'App',

  components: {
    HelloWorld
  },

  // 전역변수 이파일내에서 
  data(){
    return {
      list: []  // js 배열
    }
  },

  async mounted(){
    const reslet = await axios.get('https://jsonplaceholder.typicode.com/posts'); 
    this.list = reslet.data;
  }
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
