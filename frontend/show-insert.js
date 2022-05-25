Vue.createApp({
    data() {
        return {
            show: {
                name: '',
                length: 0,
                description: '',
                genres: []
            },
            genere:''
        }
    },
    methods: {
        createAShow() {
            axios
                .post("http://localhost:8080/show/insert", this.show)
                .then(
                    alert("INSERTED A SHOW")
                )
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        },
        addGenere(){
            this.show.genres.push(this.genere)
        },
        remove(index){
            this.show.genres.splice(index, 1)
        }
    },
    mounted: function () {

    }
}).mount("#show-insert")
