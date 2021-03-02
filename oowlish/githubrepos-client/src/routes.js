import React from 'react';
import { BrowserRouter, Switch, Route } from "react-router-dom";

import SearchForm from "./pages/SearchForm/index";
import Repos from "./pages/Repos/index";

export default function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={SearchForm}></Route>
        <Route path="/repos" component={Repos}></Route>
      </Switch>
    </BrowserRouter>
  );
}
