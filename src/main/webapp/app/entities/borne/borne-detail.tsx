import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './borne.reducer';
import { IBorne } from 'app/shared/model/borne.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IBorneDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const BorneDetail = (props: IBorneDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { borneEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="jhipsterSampleApplicationApp.borne.detail.title">Borne</Translate> [<b>{borneEntity.id} Toto</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="x">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.x">X</Translate>
            </span>
          </dt>
          <dd>{borneEntity.x}</dd>
          <dt>
            <span id="y">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.y">Y</Translate>
            </span>
          </dt>
          <dd>{borneEntity.y}</dd>
          <dt>
            <span id="amenageur">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.amenageur">Amenageur</Translate>
            </span>
          </dt>
          <dd>{borneEntity.amenageur}</dd>
          <dt>
            <span id="operateur">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.operateur">Operateur</Translate>
            </span>
          </dt>
          <dd>{borneEntity.operateur}</dd>
          <dt>
            <span id="enseigne">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.enseigne">Enseigne</Translate>
            </span>
          </dt>
          <dd>{borneEntity.enseigne}</dd>
          <dt>
            <span id="idstation">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.idstation">Idstation</Translate>
            </span>
          </dt>
          <dd>{borneEntity.idstation}</dd>
          <dt>
            <span id="station">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.station">Station</Translate>
            </span>
          </dt>
          <dd>{borneEntity.station}</dd>
          <dt>
            <span id="adstation">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.adstation">Adstation</Translate>
            </span>
          </dt>
          <dd>{borneEntity.adstation}</dd>
          <dt>
            <span id="codeinsee">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.codeinsee">Codeinsee</Translate>
            </span>
          </dt>
          <dd>{borneEntity.codeinsee}</dd>
          <dt>
            <span id="xlongitude">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.xlongitude">Xlongitude</Translate>
            </span>
          </dt>
          <dd>{borneEntity.xlongitude}</dd>
          <dt>
            <span id="ylatitude">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.ylatitude">Ylatitude</Translate>
            </span>
          </dt>
          <dd>{borneEntity.ylatitude}</dd>
          <dt>
            <span id="nbrepdc">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.nbrepdc">Nbrepdc</Translate>
            </span>
          </dt>
          <dd>{borneEntity.nbrepdc}</dd>
          <dt>
            <span id="idpdc">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.idpdc">Idpdc</Translate>
            </span>
          </dt>
          <dd>{borneEntity.idpdc}</dd>
          <dt>
            <span id="puissmax">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.puissmax">Puissmax</Translate>
            </span>
          </dt>
          <dd>{borneEntity.puissmax}</dd>
          <dt>
            <span id="typeprise">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.typeprise">Typeprise</Translate>
            </span>
          </dt>
          <dd>{borneEntity.typeprise}</dd>
          <dt>
            <span id="accesrecharge">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.accesrecharge">Accesrecharge</Translate>
            </span>
          </dt>
          <dd>{borneEntity.accesrecharge}</dd>
          <dt>
            <span id="accessibilite">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.accessibilite">Accessibilite</Translate>
            </span>
          </dt>
          <dd>{borneEntity.accessibilite}</dd>
          <dt>
            <span id="observations">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.observations">Observations</Translate>
            </span>
          </dt>
          <dd>{borneEntity.observations}</dd>
          <dt>
            <span id="datemajnoperateur">
              <Translate contentKey="jhipsterSampleApplicationApp.borne.datemajnoperateur">Datemajnoperateur</Translate>
            </span>
          </dt>
          <dd>
            {borneEntity.datemajnoperateur ? (
              <TextFormat value={borneEntity.datemajnoperateur} type="date" format={APP_DATE_FORMAT} />
            ) : null}
          </dd>
        </dl>
        <Button tag={Link} to="/borne" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/borne/${borneEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ borne }: IRootState) => ({
  borneEntity: borne.entity,
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(BorneDetail);
