import axios from 'axios';

export const getCategories =  axios.get('/Categories/selectAllCategories')
  .then(response =>{
    if(response.status === 200){
      this.categories = response.data;
      console.log("正确");
    }
  }).catch(error => console.log("错误"));
