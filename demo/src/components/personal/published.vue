<template>
  <div>
    <van-tabs :active="active" swipeable>
      <van-tab title="全部" to="/published/all"></van-tab>
      <van-tab title="私密" to="/published/private"></van-tab>
    </van-tabs>
    <router-view></router-view>
  </div>
</template>

<script>
import { ref } from "vue";
export default {
  name: "DemoPublished",

  data() {
    return {
      active: ref(0),
    };
  },

  mounted() {},

  methods: {},
};
</script>

<style lang="scss" scoped>
</style>