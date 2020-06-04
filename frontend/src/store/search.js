import router from "@/router";
import axios from 'axios'
const state={
    context: 'http://localhost:5000',
    list: [],
    pages: [],
    pager: {},
    pageNumber: '0',
    searchWord: 'null',
    item:{}
}
const actions={
    async find({commit},searchWord) {
        commit("SEARCHWORD", searchWord)
        switch (searchWord) {
            case '네이버영화' :router.push('/Movie')
                break
            case '음악' :  router.push('/Music')
                break
            case '축구' : router.push('/Soccer')
                break
        }
    },
    async transferPage({commit},payload){
        alert(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}` + '뭐야')
        axios.get(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)  // es6 쓰려고 ` ` 썼다 backtip은 +이런거없이 ${} 로
            .then(({data})=>{
                commit("TRANSFER", data)
            })
            .catch()
    },

    async retrieveOne({commit},payload){
        axios.get(`${state.context}/${payload.cate}/${payload.searchWord}`)
            .then(({data})=> {
                commit("DETAIL", data)
                router.push('/movieDetail')
            })
            .catch(()=>{
            alert('통신 실패에')
        })
    }


}
const mutations={
    // MOVIE(state,data){
    //     alert("영화 뮤테이션에서 검색된 결과수 "+data.count)
    //     state.movies=[]
    //     state.pager = data.pager
    //     data.list.forEach(item=>{
    //         state.movies.push({
    //             movieSeq: item.movieSeq,
    //             rank: item.rank,
    //             title: item.title,
    //             gap: item.gap,
    //             rankDate: item.rankDate
    //
    //         });
    //     });
    // },
    SEARCHWORD(state,data){
        alert(`뮤테이션: ${data}`)
        state.searchWord = data
    },
    TRANSFER(state,data){
        state.pager= data.pager
        state.list = data.list
    },
    DETAIL(state,data){
        state.item =data

}

}
const getters={}

export default{
    name: 'search',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}