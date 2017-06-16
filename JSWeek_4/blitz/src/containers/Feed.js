import React from 'react';
import { connect } from 'react-redux'
import Header from './Header';
import { bodyContainer } from '../components/style';
import { getFeedList } from '../actions/feed';
import Blitz from '../components/Blitz';
import Loader from '../components/Loader';

class Feed extends React.Component {

  componentWillMount() {
    this.props.dispatch(getFeedList());
  }

  render () {
    if ( Object.keys(this.props.feed).length === 0 ) return <Loader />;
      return (
          <div>
            <Header />
            <div style={bodyContainer}>
              { this.props.feed.map((blitz, index) => <Blitz key={index} data={blitz} showHeader={ true }/>)}
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
