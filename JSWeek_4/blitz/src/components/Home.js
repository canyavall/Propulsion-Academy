import React from 'react';
import Header from './Header';
import {bodyContainer} from './style';

const Home = () => (
      <div>
        <div>
          <Header />
        </div>
        <div style={bodyContainer}>
          Welcome to blitz!
        </div>
      </div>
)

export default Home;
