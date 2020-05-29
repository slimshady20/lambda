import axios from 'axios'
import router from '@/router'
const state={
    context: 'http://localhost:5000/',
    movie:[],
    count:0
    }
const actions = {
    async search({commit}, searchWord) {
        alert('검색어: ' + searchWord)
        axios.get(state.context + "movie/" + searchWord)
            .then(({data}) => {
                alert('검색된 결과 수'+data.count)
                commit('SEARCH', data)
                router.push('/movie')
            })
            .catch(() => {
                alert('통신 실패')

            })

    }
}
const mutations={
    SEARCH(state,data){
        alert("뮤테이션에서 검색된 결과수 "+data.count)
        state.movie=[]
        state.count = data.count
        data.list.forEach(item=>{
            state.movie.push({
                rank: item.rank,
                title: item.title,
                gap: item.gap,
                rankDate: item.rankDate
                // 뭐가문제지?
            })
        })
    }
}
const getters={
    movie: state => state.movie,
    count:  state => state.count
}

export default {
    name: 'movie',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}