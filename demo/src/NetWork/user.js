import { store } from "@/store/store";
import axios from "axios";
axios.defaults.baseURL='http://47.92.77.49:8080/';
axios.defaults.timeout=50000;
function register(name,password,phone,fileList){
    const params = new FormData();
    params.append("name",name);
    params.append("password",password);
    params.append("phone",phone);
    if(fileList.length!=0){
        params.append("file",fileList[0].file);
    }else{
        params.append("file",new File([],""));
    }
    
    return new Promise((resolve, reject) => {
        axios({
            method:'post',
            url:'user/register',
            // headers: {
            //   'Content-Type': 'application/x-www-form-urlencoded'
            // },
            data:params
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err)
        })

})

}
function login(phone,password){
    const params = new URLSearchParams();
    params.append("phone",phone);
    params.append("password",password);
    return new Promise((resolve, reject) => {
    axios({
        method:'post',
        url:'user/login',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        data:params
    }).then(res => {
        resolve(res)
    }).catch(err => {
        reject(err)}
    )})
}
function userMessage(id){
    return new Promise((resolve, reject) => {
        axios({
            method:'get',
            url: 'user/message?id='+id,
        }).then(res => {
            resolve(res)
        }).catch(err => {
            reject(err)
        })

})
   
}
function updateUserMessage(id,name,password,phone,fileList) {
    console.log(store.state.phone);
    const params = new FormData();
    if(parseInt(phone)!=store.state.phone){
        params.append("phone",phone);
    }

    
    params.append("id",id);
    params.append("name",name);
    params.append("password",password);


    if(fileList.length!=0){
        params.append("file",fileList[0].file);
    }else{
        params.append("file",new File([],""));
    }
    
    return new Promise((resolve, reject) => {
        axios({
            method:'post',
            url:'user/update',
            // headers: {
            //   'Content-Type': 'application/x-www-form-urlencoded'
            // },
            data:params
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err)
        })

})}
export{
    register,login,userMessage,updateUserMessage
}