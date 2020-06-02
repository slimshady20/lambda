<template>
    <div>
        <div>
            <input id="search" v-model="searchWord" type="text" style=" background-repeat: no-repeat; background-position: 88% 50%, 98% 50%;" title="검색">
        </div>
        <div id="box">
            <input  @click="search" id="google_search" type="button" value="Google 검색">
        </div>
        <div><h3>>검색된 수 : {{count}}</h3></div>
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
                <tr v-for="item of movie" :key="item.rank">
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
        <span v-if="existPrev" style = "width: 50px; height: 50px; border: 1px solid black; margin: 5px">이전</span>
        <span v-for="i of arr"  :key="i" style = "width: 50px; height: 50px; border: 1px solid black; margin: 5px" >{{i+5}}</span>
        <span v-if="existNext" style = "width: 50px; height: 50px; border: 1px solid black; margin: 5px">다음</span>
        </div>
    </div>
</template>

<script>
    import{mapState} from "vuex";
    export default {
        data(){
            return{
                page:1 ,
                searchWord: '',
                existPrev: true,
                existNext: true,
                arr:[]
            }
        },
        methods:{
            search(){
                alert("검색단어: "+ this.searchWord);}},
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