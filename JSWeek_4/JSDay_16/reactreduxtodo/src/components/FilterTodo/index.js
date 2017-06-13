import React from 'react';

export default class todo extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      listShow: "All"
    }

  }
  render(){
    return(
      <div>
        <label htmlFor="all">All</label>
          <input type="radio" name="filter" id="all" onClick={() => this.setState({listShow: "All"})}/>
        <label htmlFor="complete">Complete</label>
          <input type="radio" name="filter" id="complete" onClick={() => this.setState({listShow: "Complete"})}/>
        <label htmlFor="nocomplete">No Completed</label>
          <input type="radio" name="filter" id="notcomplete" onClick={() => this.setState({listShow: "Nocomplete"})}/>
      </div>
    )
  }
}
