import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import App from './components/App/index';
import './index.css';
import store from './store/index';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

ReactDOM.render(
  <Provider store={store}>
    <Router>
      <Switch>
      <Route exact path="/" component={ App } />
      <Route exact path="/test" component={ App } />
      </Switch>
    </Router>
  </Provider>,
  document.getElementById('root')
)
