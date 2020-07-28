import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Borne from './borne';
import BorneDetail from './borne-detail';
import BorneUpdate from './borne-update';
import BorneDeleteDialog from './borne-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={BorneUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={BorneUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={BorneDetail} />
      <ErrorBoundaryRoute path={match.url} component={Borne} />
    </Switch>
    <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={BorneDeleteDialog} />
  </>
);

export default Routes;
