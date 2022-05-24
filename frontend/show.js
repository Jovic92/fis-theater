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
            shows:[]
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
                })
                .catch(function (error) {
                    alert("An error has occurred")
                })
        }
    },
    mounted: function () {

    }
}).mount("#show")