Vue.createApp({
    data() {
        return {
            dateOfPerformance: '',
            performances: []
        }
    },
    methods: {
        find() {
            axios
                .get("http://localhost:8080/performance/date/" + this.dateOfPerformance)
                .then(resp => {
                    this.performances = resp.data
                    console.log(this.performances)
                })
        }
    },
    mounted: function () {

    }
}).mount("#perf-date")
