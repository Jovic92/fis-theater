Vue.createApp({
  data() {
    return {
      scenes: [],
      sceneName: '',
      performances: []
    }
  },
  methods: {
    onSelectScene() {
      axios
        .get("http://localhost:8080/performance/scene/" + this.sceneName)
        .then(response => {
          this.performances = response.data
        })
    }
  },
  mounted: function () {
    axios
      .get("http://localhost:8080/scenes/all")
      .then(respons => {
        this.scenes = respons.data
        console.log(this.scenes)
      })
  }
}).mount("#scene")
