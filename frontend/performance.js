Vue.createApp({
    data() {
        return {
            showNameForSearch: '',
            performancesDateAndScene: []
        }
    },
    methods: {
        getPerformanceDateAndSceneName() {
            axios
                .get("http://localhost:8080/performance/date-and-scene/" + this.showNameForSearch)
                .then(response => {
                    console.log(response)
                    this.performancesDateAndScene = response.data
                })
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        }
    },
    mounted: function () {
    }
}).mount("#perf")
