import React from 'react';
import { Link } from 'react-router-dom';
import { AppBar } from 'material-ui';
import RaisedButton from 'material-ui/RaisedButton';

const Home = () => (
      <div>
        <div>
          <AppBar
            title="Welcome to e-trivial"
            iconClassNameRight="muidocs-icon-navigation-expand-more"
          />
        </div>
        <div className = "bodyContainer">
          <Link to="/game/1"><RaisedButton label="Start Game" secondary={true} /></Link>
        </div>
      </div>
)

export default Home;
