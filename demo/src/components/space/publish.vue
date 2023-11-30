<template>
  <div>
    <van-nav-bar
      title="我要发表"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
    >
      <template #right>
        <van-icon name="success" size="25" @click="submit()" />
      </template>
    </van-nav-bar>
    <van-form size="large">
      <van-cell-group inset>
        <van-field v-model="title" name="标题" placeholder="请输入标题" />
        <van-field
          v-model="content"
          autosize
          rows="4"
          type="textarea"
          placeholder="请输入内容"
          show-word-limit
        />
        <van-field name="switch" label="私密上传">
          <template #input>
            <van-switch v-model="checked" size="20" />
          </template>
        </van-field>
        <van-field name="uploader">
          <template #input>
            <van-uploader v-model="fileList" multiple />
          </template>
        </van-field>
      </van-cell-group>
    </van-form>
  </div>
</template>

<script>
import { addArticle } from "@/NetWork/article";
import { store } from "@/store/store";

export default {
  name: "DemoPublish",

  data() {
    return {
      content: "",
      title: "",
      checked: false,
      fileList: [],
    };
  },

  mounted() {},

  methods: {
    onClickLeft() {
      this.$router.go(-1);
    },
    submit() {
      console.log(this.content);
      console.log(this.title);
      // for (let i = 0; i < this.fileList.length; i++) {
      //   this.fileList[i] = this.fileList[i].raw;
      // }
      console.log(this.fileList);
      addArticle(
        store.state.id,
        this.title,
        this.content,
        this.fileList,
        this.checked
      ).then((res) => {
        console.log(res);
        if (res && res.data && res.data.code == 200) {
          this.$toast("发表成功");
          this.$router.go(-1);
        } else {
          this.$toast("发表失败");
        }
      });
    },
  },
};
</script>

<style lang="scss" scoped>
</style>