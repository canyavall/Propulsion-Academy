import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';
import {BrowserRouter as  Router, Route, Switch } from 'react-router-dom';
import store from './store/index';
import Game from './components/Game';
import Home from './components/Home';
import './index.css';


injectTapEventPlugin();

ReactDOM.render(
          <MuiThemeProvider>
            <Provider store = {store}>
              <Router>
                <Switch>
                  <Route exact path="/" component={ Home } />
                  <Route exact path="/game/:questionId" component={ Game } />
                </Switch>
              </Router>
            </Provider>
          </MuiThemeProvider>,
          document.getElementById('root')
);
