Vue.createApp({
    data() {
        return {
            show: {
                name: '',
                description: '',
                length: 0,
                genres: []
            },
            actor: {
                firstname: '',
                lastname: ''
            },
            shows: [],
            message: ''
        }
    },
    methods: {
        search() {

            // .get("http://localhost:8080/visitors/get/" + this.visitor.firstname + "/" + this.visitor.lastname)

            axios
                .get("http://localhost:8080/show/getAllShowsForActor?firstname=" + this.actor.firstname + "&ln=" + this.actor.lastname)
                .then(response => {
                    this.shows = response.data
                    console.log(this.shows)
                    if (this.shows.length == 0) {
                        this.message = "THERE ARE NO RESULTS"
                    } else {
                        this.message = ""
                    }
                })
                .catch(function (error) {
                    alert("An error has occurred")
                })
        },
        getAll(){
            axios
            .get("http://localhost:8080/show/getAll/")
            .then(response => {
                console.log(response)
                this.shows = response.data
            })
            .catch(function (error) {
                console.log(error)
                alert("AN ERROR HAS OCCURED")
            }) 
        }
    },
    mounted: function () {

    }
}).mount("#show")