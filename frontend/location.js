Vue.createApp({
    data() {
        return {
            dateOfShow: '',
            nameOfShow: '',
            locations: []
        }
    },
    methods: {
        show() {
            axios
                .get("http://localhost:8080/location/" + this.dateOfShow + "/" + this.nameOfShow)
                .then(response => {
                    console.log(response.data)
                    this.locations = response.data
                })
                .catch(function (err) {
                    console.log(err)
                    alert("ERROR HAS HAPPENED")
                })
        }
    },
    mounted: function () {

    }
}).mount("#location")
