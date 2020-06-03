<template>
    <div>
        <div>
            <input id="search" type="text" style=" background-repeat: no-repeat; background-position: 88% 50%, 98% 50%;" title="검색">
        </div>

        <div><h3>>검색된 수 : {{pager.rowCount}}</h3></div>
        <a @click="myAlert('aaaa')">테스트</a>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">영화 순위</th>
                    <th class="text-left">영화 제목</th>
                    <th class="text-left">변동폭</th>
                    <th class="text-left">날짜</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.movieSeq">
                    <td>{{item.movieSeq}}</td>
                    <td>{{item.title}}</td>
                    <td>{{item.gap}}</td>
                    <td>{{item.rankDate}}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div id="app-3" class ="text-center" style="margin:0 auto; width: 500px; height: 100px">
            <!--<v-pagination v-model="page" :length="5" :total-visible="5" label="Toggle circle"></v-pagination>-->
        <span v-if="pager.existPrev" style = "width: 50px; height: 50px; border: 1px solid black; margin: 5px">이전</span>
        <span @click="transferPage(i)" v-for="i of pages"  :key="i" style = "width: 50px; height: 50px; border: 1px solid black; margin: 5px" >{{i}}</span>
        <span v-if="pager.existNext" style = "width: 50px; height: 50px; border: 1px solid black; margin: 5px">다음</span>
        </div>
    </div>
</template>

<script>
    import{mapState} from "vuex";
    import {proxy} from "./mixins/proxy"
    export default {
        mixins: [proxy],
        created(){ // creadted 먼저 작동 . 그다음에 paging 작동
            console.log('페이징가기전: ')
            let json = proxy.methods.paging(`${this.$store.state.search.context}/movies/null/0`)
            this.$store.state.search.list = json.movies
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp
            console.log('페이징 다녀온다음: '+json.temp.pageSize)
        },
        computed: {
            ...mapState({  // vuex꺼
                movie: state=> state.movie.movie,
                list: state => state.search.list,
                pages: state => state.search.pages,
                pager: state => state.search.pager
            })
        },
        methods:{
            transferPage(d){
                alert(`이동 페이지 ${d-1}`)
                this.$store.dispatch('search/transferPage',{cate:'movies',
                    searchWord:'null',
                    pageNumber: d-1})
            }
        },
    }

</script>

<style scoped>
    #search{
        display: block;
        margin: 0 auto;
        width: 550px;
        height: 50px;
        font-size: 15pt;
        box-shadow: 3px 3px 5px #C3C3C3;
        border: 1px solid #EAEAEA;
    }
    #box{
        text-align: center;
    }
    #google_search{
        width: 135px;
        height: 40px;
        margin: 30px 3px;
        border: none;
        background-color: #F4F4F4;
        font-weight: bold;
        color: grey;
    }
</style>