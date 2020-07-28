import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './borne.reducer';
import { IBorne } from 'app/shared/model/borne.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IBorneProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Borne = (props: IBorneProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { borneList, match, loading } = props;
  return (
    <div>
      <h2 id="borne-heading">
        <Translate contentKey="jhipsterSampleApplicationApp.borne.home.title">Bornes</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="jhipsterSampleApplicationApp.borne.home.createLabel">Create new Borne</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {borneList && borneList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.x">X</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.y">Y</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.amenageur">Amenageur</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.operateur">Operateur</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.nenseigne">Nenseigne</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.idstation">Idstation</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.nstation">Nstation</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.adstation">Adstation</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.codeinsee">Codeinsee</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.xlongitude">Xlongitude</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.ylatitude">Ylatitude</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.nbrepdc">Nbrepdc</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.idpdc">Idpdc</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.puissmax">Puissmax</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.typeprise">Typeprise</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.accesrecharge">Accesrecharge</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.accessibilite">Accessibilite</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.observations">Observations</Translate>
                </th>
                <th>
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.datemajnoperateur">Datemajnoperateur</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {borneList.map((borne, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${borne.id}`} color="link" size="sm">
                      {borne.id}
                    </Button>
                  </td>
                  <td>{borne.x}</td>
                  <td>{borne.y}</td>
                  <td>{borne.amenageur}</td>
                  <td>{borne.operateur}</td>
                  <td>{borne.nenseigne}</td>
                  <td>{borne.idstation}</td>
                  <td>{borne.nstation}</td>
                  <td>{borne.adstation}</td>
                  <td>{borne.codeinsee}</td>
                  <td>{borne.xlongitude}</td>
                  <td>{borne.ylatitude}</td>
                  <td>{borne.nbrepdc}</td>
                  <td>{borne.idpdc}</td>
                  <td>{borne.puissmax}</td>
                  <td>{borne.typeprise}</td>
                  <td>{borne.accesrecharge}</td>
                  <td>{borne.accessibilite}</td>
                  <td>{borne.observations}</td>
                  <td>
                    {borne.datemajnoperateur ? <TextFormat type="date" value={borne.datemajnoperateur} format={APP_DATE_FORMAT} /> : null}
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${borne.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${borne.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${borne.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.home.notFound">No Bornes found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ borne }: IRootState) => ({
  borneList: borne.entities,
  loading: borne.loading,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Borne);
