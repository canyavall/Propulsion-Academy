import React from 'react';
import { connect } from 'react-redux'
import Header from './Header';
import { bodyContainer } from '../components/style';
import { getFeedList } from '../actions/feed';
import Blitz from '../components/Blitz';

class Feed extends React.Component {

  componentWillMount() {
    this.props.dispatch(getFeedList());
  }

  render () {
    console.log(this.props);
    if ( Object.keys(this.props.feed).length === 0 ) return <div>Loading</div>
    return (
        <div>
          <div>
            <Header />
          </div>
          <div style={bodyContainer}>
            { this.props.feed.map((blitz, index) => <Blitz key= {index} data={blitz}/>)}
          </div>
        </div>
      )
  }
}

const mapStateToProps = (state) => {
  return {
    feed: state.feed
  };
}

export default connect(mapStateToProps)(Feed);
