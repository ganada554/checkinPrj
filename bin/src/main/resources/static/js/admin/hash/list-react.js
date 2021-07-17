/**
 * 
 */
 
class List extends React.Component{
	
	constructor(){
		super();
		this.state={
			list:[],
			addMode:"off",
			delMode:"off",
			addBgColor:"#287e19",
			delBgColor:"#287e19"
		}
	}
	
	
	componentDidMount(){
		
		fetch('/api/hash/list')
			.then(response=>response.json())
			.then(json=>{
				console.log(json);
				this.setState(json);
			});
	}
	
	
	addToggle(){
		console.log("k")
		if(this.state.addMode === "off"){
			this.setState({
				addMode:"on",
				addBgColor:"orange"
				
			})
		}
		else if(this.state.addMode === "on"){
			this.setState({
				addMode:"off",
				addBgColor:"#287e19"
			})
		}
		
	}
	
		delToggle(){
		console.log("k")
		if(this.state.delMode === "off"){
			this.setState({
				delMode:"on",
				delBgColor:"orange"
				
			})
		}
		else if(this.state.delMode === "on"){
			this.setState({
				delMode:"off",
				delBgColor:"#287e19"
			})
		}
		
	}
	
	render(){
		return <main>
        <div className="title">ADMIN</div>
        <nav className="mini-nav">
            <a >서점</a>
            <a >회원</a>
            <a >스탬프 투어</a>
            <a >후기</a>
            <a className="mini-nav-page">해시태그</a>
        </nav>

        
        <form action="/admin/hash/result" method="post" >
            <div className="operation">
                <input type="text" name="q" />
                <input type="submit" className="btn" value="검색" />
            </div>
        </form>
	
			<div>
				<a className="btn" style={{backgroundColor:this.state.addBgColor}} onClick={this.addToggle.bind(this)}>추가</a>
                
                <a className="btn" style={{backgroundColor:this.state.delBgColor}} onClick={this.delToggle.bind(this)}>삭제</a>
			</div>

			{this.state.list.map(h=>{
				 return <div className="card">
                		<div className="hi-span" >
                    		<span>{h.name}</span>
              		 	</div>
           		 		</div>
			})}
           
    </main>;
	}
}

ReactDOM.render(<List />, document.querySelector("#root"));