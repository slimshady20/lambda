<template>
    <div>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">영화 순위</th>
                    <th class="text-left">rank</th>
                    <th class="text-left">영화 제목</th>
                    <th class="text-left">변동폭</th>
                    <th class="text-left">날짜</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>{{item.movieSeq}}</td>
                    <td>{{item.rank}}</td>
                    <td >{{item.title}}</td>
                    <td>{{item.gap}}</td>
                    <td>{{item.rankDate}}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
    </div>
</template>
<script>
    import {mapState} from "vuex";

    export default {
        name: "MovieDetail",
        computed: {
            ...mapState({  // vuex꺼
                item: state => state.search.item
                // state가 매핑구조로가기떄문에 뒤에 item이 앞에 item: 으로

            })
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