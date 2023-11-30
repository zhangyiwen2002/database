import axios from "axios";

axios.defaults.baseURL='http://47.92.77.49:8080/';
axios.defaults.timeout=50000;
function getAllRecords(){
    return new Promise((resolve, reject) => {
        axios({
            method:'get',
            url: "article/allArticles",
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err)
        })

})
}
function getUserRecords(tag,id){
    return new Promise((resolve, reject) => {
        axios({
            method:'get',
            url: 'article/userArticles?userId='+id+'&tag='+tag,
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err)
        })

})

}
function searchRecords(name){
    return new Promise((resolve, reject) => {
        axios({
            method:'get',
            url: 'article/searchByName?name='+name,
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err)
        })

})
   
}
function searchRecordsById(id){
    return new Promise((resolve, reject) => {
        axios({
            method:'get',
            url: 'article/searchById?id='+id,
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err)
        })

})
   
}
function deleteRecords(id){
    return new Promise((resolve, reject) => {
        const params = new URLSearchParams();
        params.append("id",id);
        axios({
            method:'post',
            url:'article/delete',
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            },
            data:params
        }).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err)
        })

})


}
function addArticle(userId,title,content,fileList,checked){
    if(checked==false){
        checked=0
    }else{
        checked=1
    }
    const params = new FormData();
    params.append("userId",userId);
    params.append("title",title);
    params.append("content",content);
    for(let i=0;i<fileList.length;i++){
        params.append("file",fileList[i].file);
    }
    if(fileList.length==0){
        params.append("file",new File([],""));
    }
    params.append("isprivate",checked);
    return new Promise((resolve, reject) => {
        axios({
            method:'post',
            url:'article/add',
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
export{
    getAllRecords,getUserRecords,searchRecords,deleteRecords,searchRecordsById,addArticle
}