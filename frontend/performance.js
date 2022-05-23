Vue.createApp({
    data() {
        return {
            showNameForSearch: '',
            performancesDateAndScene: [],
            shows: [],
            show: {
                name: '',
                description: '',
                length: 0,
                genere: []
            }
        }
    },
    methods: {
        getPerformanceDateAndSceneName() {
            axios
                .get("http://localhost:8080/performance/date-and-scene/" + this.showNameForSearch)
                .then(response => {
                    // console.log(response)
                    this.performancesDateAndScene = response.data
                })
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        },
        setSelectedShow() {
            this.shows.forEach(elem => {
                // console.log(elem.name)
                // console.log(this.showNameForSearch)
                if (elem.name === this.showNameForSearch) {
                    this.show = elem
                    console.log(this.show)
                }
            })
            
            // = this.shows.
        }
    },
    mounted: function () {
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
}).mount("#perf")
