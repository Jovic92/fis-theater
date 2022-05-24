Vue.createApp({
    data() {
        return {
            ticket: {
                idPerformance: 0,
                idVisitor: 0,
                idLocation: 0
            }
        }
    },
    methods: {
        buy() {
            axios
                .post("http://localhost:8080/ticket/buy", this.ticket)
                .then(response => {
                    console.log(response.data)
                })
                .catch(function (error) {
                    alert("AN ERROR HAS HAPPENED")
                })
        }
    },
    mounted: function () {

    }
}).mount("#reserve")
