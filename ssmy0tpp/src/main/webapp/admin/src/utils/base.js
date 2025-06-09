const base = {
    get() {
                return {
            url : "http://localhost:8080/ssmy0tpp/",
            name: "ssmy0tpp",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmy0tpp/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "电商扶贫平台网站"
        } 
    }
}
export default base
