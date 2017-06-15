import React from 'react';
import { AppBar } from 'material-ui';
import FlatButton from 'material-ui/FlatButton';
import { Link } from 'react-router-dom';
import {barButtonStyle} from '../components/style';
import {connect} from 'react-redux'
import { withRouter } from 'react-router';
import {userLogout} from '../actions/user'
import Avatar from 'material-ui/Avatar';


class Header extends React.Component {

  render () {
    const rightButtonsLogged = (
        <div>
            <Link to="/"><FlatButton label="Home" style={barButtonStyle} /></Link>
            <Link to="/feed"><FlatButton label="Feed" style={barButtonStyle} /></Link>
            <Avatar src={this.props.user.avatar} />
            <Link to="/"><FlatButton label="Logout" onClick={ this.logOut } style={barButtonStyle} /></Link>
        </div>
      );

    const rightButtonsNotLogged = (
        <div>
            <Link to="/"><FlatButton label="Home" style={barButtonStyle} /></Link>
            <Link to="/login"><FlatButton label="Login" style={barButtonStyle} /></Link>
        </div>
      );

    let rightButtons = rightButtonsNotLogged;
    if (this.props.user.token !== null) rightButtons = rightButtonsLogged;
        return <div>
          <AppBar
            title="Welcome to Blitz"
            showMenuIconButton={ false }
            iconElementRight ={ rightButtons }
          >
          </AppBar>
        </div>;
  }

  logOut = () => {
    window.localStorage.clear();
    this.props.dispatch(userLogout());
    this.props.history.push("/");
  }
}

const ComposedWithRouter = withRouter(Header);

const mapStateToProps = (state) => {
  return { user: state.user };
}
export default connect(mapStateToProps)(ComposedWithRouter);
