"use strict";(self["webpackChunkdemo"]=self["webpackChunkdemo"]||[]).push([[289],{9289:function(t,e,a){a.r(e),a.d(e,{default:function(){return m}});var o=function(){var t=this,e=t._self._c;return e("div",{attrs:{id:"DemoIndex"}},[e("van-calendar",{attrs:{title:"快来学习打卡吧",poppable:!1,"show-confirm":!1,"min-date":t.maxDate,"max-date":t.maxDate,formatter:t.formatter}}),e("div",{staticClass:"month"},[t._v(" 本月已学习打卡"),e("span",[t._v(t._s(t.days))]),t._v("天 ")]),e("div",{staticClass:"total"},[t._v(" 已累计学习打卡"),e("span",{domProps:{textContent:t._s(t.records.length)}}),t._v("天 ")]),e("div",{staticClass:"button"},[t.isClockIn?e("van-button",{attrs:{round:"",type:"warning",size:"large",disabled:""}},[t._v("今日已打卡")]):e("van-button",{attrs:{round:"",type:"warning",size:"large"},on:{click:function(e){return t.clockIn()}}},[t._v("我要打卡")])],1)],1)},s=[],n=a(6138),r=a(9669),l=a.n(r);function d(t){return new Promise(((e,a)=>{const o=new URLSearchParams;o.append("userId",t),o.append("date",new Date),l()({method:"post",url:"clockin/",headers:{"Content-Type":"application/x-www-form-urlencoded"},data:o}).then((t=>{e(t)})).catch((t=>{a(t)}))}))}function i(t){return new Promise(((e,a)=>{l()({method:"get",url:"clockin/records?userId="+t,headers:{"Content-Type":"application/x-www-form-urlencoded"}}).then((t=>{e(t)})).catch((t=>{a(t)}))}))}l().defaults.baseURL="http://47.92.77.49:8080/",l().defaults.timeout=5e4;var c={name:"DemoIndex",async created(){""!=n.h.state.id&&await i(n.h.state.id).then((t=>{console.log(t),this.records=t.data.data;for(let e=0;e<this.records.length;e++){let t=new Date(this.records[e]);t.getFullYear()==this.maxDate.getFullYear()&&t.getMonth()==this.maxDate.getMonth()&&(this.days++,t.getDate()==this.maxDate.getDate()&&(this.isClockIn=1))}}))},data(){return{records:[],days:0,totaldays:2,isClockIn:0,maxDate:new Date}},mounted(){},methods:{formatter(t){const e=t.date.getFullYear(),a=t.date.getMonth()+1,o=t.date.getDate();for(let s=0;s<this.records.length;s++){let n=new Date(this.records[s]);e===n.getFullYear()&&a===n.getMonth()+1&&o===n.getDate()&&(t.bottomInfo="已打卡")}return t},clockIn(){""!=n.h.state.id?d(n.h.state.id).then((t=>{console.log(t),200==t.data.code&&(this.$toast("打卡成功"),this.isClockIn=1,this.$router.go(0))})):this.$toast("请先登录")}}},h=c,g=a(1001),u=(0,g.Z)(h,o,s,!1,null,"20bd8dd8",null),m=u.exports},6138:function(t,e,a){a.d(e,{h:function(){return o}});const o={debug:!0,state:{id:null==localStorage.getItem("id")?"":localStorage.getItem("id"),password:null==localStorage.getItem("password")?"":localStorage.getItem("password"),phone:null==localStorage.getItem("phone")?"":localStorage.getItem("phone")},setMessageAction(t,e,a){this.debug&&console.log("setMessageAction triggered with",t),this.state.id=t,this.state.password=e,this.state.phone=a,localStorage.setItem("id",t),localStorage.setItem("phone",a),localStorage.setItem("password",e)},clearMessageAction(){this.debug&&console.log("clearMessageAction triggered"),localStorage.clear(),this.state.id="",this.state.password="",this.state.phone=""}}}}]);
//# sourceMappingURL=289.3ddfee37.js.map