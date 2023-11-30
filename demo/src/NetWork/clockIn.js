import axios from "axios";
axios.defaults.baseURL='http://47.92.77.49:8080/';
axios.defaults.timeout=50000;
function clockIn(id){
    return new Promise((resolve, reject) => {
        
            const params = new URLSearchParams();
            params.append('userId',id);
            params.append('date',new Date());
            axios({
                method:'post',
                url:'clockin/',
                headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
                },
                data:params
            }).then(res=>{
                resolve(res)
            }).catch(err => {
                reject(err)
            })
        }
    )
}
function getUserRecords(id){
    return new Promise((resolve, reject) => {
        axios({
            method:'get',
            url:'clockin/records'+'?userId='+id,
            headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
            },
        }).then(res=>{
            resolve(res)
        }).catch(err => {
            reject(err)
        })
   })
}
export{
    clockIn,getUserRecords
}