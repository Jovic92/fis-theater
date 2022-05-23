Vue.createApp({
    data() {
        return {
            visitor: {
                firstname: '',
                lastname: ''
            }
        }
    },
    methods: {
        addVisitor() {
            // alert("ABOUT TO ADD VISITOR " + this.visitor.firstname + " " + this.visitor.lastname)
            axios
                .post("http://localhost:8080/visitor/save", this.visitor)
                .then(response => console.log(response))
                .catch(function (error) {
                    console.log(error)
                    alert("AN ERROR HAS OCCURED")
                })
        }
    },
    mounted: function () {

    }
}).mount("#visitor")
