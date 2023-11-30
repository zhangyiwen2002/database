<template>
  <div id="app">
    <router-view></router-view>
    <van-tabbar route placeholder>
      <van-tabbar-item replace to="/" icon="home-o">打卡圣地</van-tabbar-item>
      <van-tabbar-item replace to="/space" icon="chat-o"
        >分享交流</van-tabbar-item
      >
      <van-tabbar-item replace to="/personal" icon="friends-o"
        >我的</van-tabbar-item
      >
    </van-tabbar>
  </div>
</template>

<script>
export default {
  name: "App",
  components: {},
};
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
