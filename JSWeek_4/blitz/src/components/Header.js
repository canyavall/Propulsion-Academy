import React from 'react';
import { AppBar } from 'material-ui';
import FlatButton from 'material-ui/FlatButton';
import { Link } from 'react-router-dom';
import {barButtonStyle} from './style';

const rightButtons = (
    <div>
        <Link to="/"><FlatButton label="Home" style={barButtonStyle} /></Link>
        <Link to="/login"><FlatButton label="Login" style={barButtonStyle} /></Link>
    </div>
  );

const Header = () => (
      <div>
        <AppBar
          title="Welcome to Blitz"
          showMenuIconButton={false}
          iconElementRight ={ rightButtons }
        >
        </AppBar>
      </div>
)

export default Header;
