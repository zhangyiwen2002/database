<template>
  <div id="DemoIndex">
    <van-calendar
      title="快来学习打卡吧"
      :poppable="false"
      :show-confirm="false"
      :min-date="maxDate"
      :max-date="maxDate"
      :formatter="formatter"
    ></van-calendar>
    <div class="month">
      本月已学习打卡<span>{{ days }}</span
      >天
    </div>
    <div class="total">
      已累计学习打卡<span v-text="records.length"></span>天
    </div>
    <div class="button">
      <van-button round type="warning" size="large" disabled v-if="isClockIn"
        >今日已打卡</van-button
      >
      <van-button round type="warning" size="large" v-else @click="clockIn()"
        >我要打卡</van-button
      >
    </div>
  </div>
</template>

<script>
import { store } from "@/store/store";
import { clockIn } from "../../NetWork/clockIn";
import { getUserRecords } from "../../NetWork/clockIn";
export default {
  name: "DemoIndex",
  async created() {
    if (store.state.id != "") {
      await getUserRecords(store.state.id).then((res) => {
        console.log(res);
        this.records = res.data.data;
        for (let i = 0; i < this.records.length; i++) {
          let d = new Date(this.records[i]);
          if (
            d.getFullYear() == this.maxDate.getFullYear() &&
            d.getMonth() == this.maxDate.getMonth()
          ) {
            this.days++;
            if (d.getDate() == this.maxDate.getDate()) {
              this.isClockIn = 1;
            }
          }
        }
      });
    }
  },
  data() {
    return {
      // maxDate: new Date(new Date().valueOf() + 24 * 60 * 60 * 1000),
      records: [],
      days: 0,
      totaldays: 2,
      isClockIn: 0,
      maxDate: new Date(),
    };
  },

  mounted() {},

  methods: {
    formatter(day) {
      const year = day.date.getFullYear();
      const month = day.date.getMonth() + 1;
      const date = day.date.getDate();
      for (let i = 0; i < this.records.length; i++) {
        // console.log(this.records[i]);
        let d = new Date(this.records[i]);
        if (year === d.getFullYear()) {
          if (month === d.getMonth() + 1) {
            if (date === d.getDate()) {
              day.bottomInfo = "已打卡";
            }
          }
        }
      }

      return day;
    },
    clockIn() {
      if (store.state.id != "") {
        clockIn(store.state.id).then((res) => {
          console.log(res);
          if (res.data.code == 200) {
            this.$toast("打卡成功");
            this.isClockIn = 1;
            this.$router.go(0);
          }
        });
      } else {
        this.$toast("请先登录");
      }
    },
  },
};
</script>

<style scoped>
#DemoIndex {
  padding-top: 1rem;
}
.month,
.total {
  font-family: "方正舒体";
  font-size: 1rem;
  padding: 0.5rem;
  text-align: center;
}
.total {
  color: #aaa;
}
.month span,
.total span {
  font-weight: 700;
  color: red;
}
.button {
  padding: 0 3rem;
  padding-top: 0.5rem;
  text-align: center;
}
</style>