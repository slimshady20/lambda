<template>
    <div>
        <div>
            <input id="search" v-model="searchWord" type="text" style=" background-repeat: no-repeat; background-position: 88% 50%, 98% 50%;" title="검색">
        </div>
        <div id="box">
            <input  @click="search" id="google_search" type="button" value="Google 검색">
        </div>
        <div><h3>>검색된 수 : {{pager.rowCount}}</h3></div>
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
                    <td>{{item.rank}}</td>
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
        <span v-for="i of pages"  :key="i" style = "width: 50px; height: 50px; border: 1px solid black; margin: 5px" >{{i}}</span>
        <span v-if="pager.existNext" style = "width: 50px; height: 50px; border: 1px solid black; margin: 5px">다음</span>
        </div>
    </div>
</template>

<script>
    import{mapState} from "vuex";
    import axios from "axios";
    export default {
        methods:{
            search(){
                alert("d")
            }
        },
        created(){
            axios
                .get(`${this.$store.state.search.context}/movies/${this.$store.state.search.searchWord}/${this.$store.state.search.pageNumber}`)
                .then(res=>{
                    res.data.list.forEach(elem => {this.list.push(elem)})
                    this.pager = res.data.pager
                    let i = this.pager.pageStart +1
                    let arr = []
                    console.log(`페이지 끝 : ${this.pager.pageEnd}`)
                    for(; i <= this.pager.pageEnd +1; i++){
                        arr.push(i)
                    }
                    this.pages = arr
                })
                .catch(err=>{
                    alert(`영화 통신 실패 ${err}`)
                })
        },
        data(){
            return{
                pageNumber: 0,
                pages: [1,2,3,4,5],
                list: [],
                pager: {},
                totalCount: '',
                searchWord: '',
                existPrev: false,

            }
        },
        computed: {
            ...mapState({
                count: state => state.movie.count,
                movie: state=> state.movie.movie

            })
        }
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