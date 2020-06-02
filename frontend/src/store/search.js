import router from "@/router";

const state={
    context: 'http://localhost:5000/',
    soccer: [],
    movies: [],
    pager: {},
    pageNumber: 0,
    searchWord: 'null'
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


}
const mutations={
    MOVIE(state,data){
        alert("영화 뮤테이션에서 검색된 결과수 "+data.count)
        state.movies=[]
        state.pager = data.pager
        data.list.forEach(item=>{
            state.movies.push({
                movieSeq: item.movieSeq,
                rank: item.rank,
                title: item.title,
                gap: item.gap,
                rankDate: item.rankDate

            });
        });
    },
    SEARCHWORD(state,data){
        alert(`뮤테이션: ${data}`)
        state.searchWord = data
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