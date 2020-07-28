import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './borne.reducer';
import { IBorne } from 'app/shared/model/borne.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IBorneUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const BorneUpdate = (props: IBorneUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { borneEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/borne');
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    values.datemajnoperateur = convertDateTimeToServer(values.datemajnoperateur);

    if (errors.length === 0) {
      const entity = {
        ...borneEntity,
        ...values,
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="jhipsterSampleApplicationApp.borne.home.createOrEditLabel">
            <Translate contentKey="jhipsterSampleApplicationApp.borne.home.createOrEditLabel">Create or edit a Borne</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : borneEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="borne-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="borne-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="xLabel" for="borne-x">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.x">X</Translate>
                </Label>
                <AvField id="borne-x" type="string" className="form-control" name="x" />
              </AvGroup>
              <AvGroup>
                <Label id="yLabel" for="borne-y">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.y">Y</Translate>
                </Label>
                <AvField id="borne-y" type="string" className="form-control" name="y" />
              </AvGroup>
              <AvGroup>
                <Label id="amenageurLabel" for="borne-amenageur">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.amenageur">Amenageur</Translate>
                </Label>
                <AvField id="borne-amenageur" type="text" name="amenageur" />
              </AvGroup>
              <AvGroup>
                <Label id="operateurLabel" for="borne-operateur">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.operateur">Operateur</Translate>
                </Label>
                <AvField id="borne-operateur" type="text" name="operateur" />
              </AvGroup>
              <AvGroup>
                <Label id="nenseigneLabel" for="borne-nenseigne">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.nenseigne">Nenseigne</Translate>
                </Label>
                <AvField id="borne-nenseigne" type="text" name="nenseigne" />
              </AvGroup>
              <AvGroup>
                <Label id="idstationLabel" for="borne-idstation">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.idstation">Idstation</Translate>
                </Label>
                <AvField id="borne-idstation" type="string" className="form-control" name="idstation" />
              </AvGroup>
              <AvGroup>
                <Label id="nstationLabel" for="borne-nstation">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.nstation">Nstation</Translate>
                </Label>
                <AvField id="borne-nstation" type="text" name="nstation" />
              </AvGroup>
              <AvGroup>
                <Label id="adstationLabel" for="borne-adstation">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.adstation">Adstation</Translate>
                </Label>
                <AvField id="borne-adstation" type="text" name="adstation" />
              </AvGroup>
              <AvGroup>
                <Label id="codeinseeLabel" for="borne-codeinsee">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.codeinsee">Codeinsee</Translate>
                </Label>
                <AvField id="borne-codeinsee" type="text" name="codeinsee" />
              </AvGroup>
              <AvGroup>
                <Label id="xlongitudeLabel" for="borne-xlongitude">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.xlongitude">Xlongitude</Translate>
                </Label>
                <AvField id="borne-xlongitude" type="string" className="form-control" name="xlongitude" />
              </AvGroup>
              <AvGroup>
                <Label id="ylatitudeLabel" for="borne-ylatitude">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.ylatitude">Ylatitude</Translate>
                </Label>
                <AvField id="borne-ylatitude" type="string" className="form-control" name="ylatitude" />
              </AvGroup>
              <AvGroup>
                <Label id="nbrepdcLabel" for="borne-nbrepdc">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.nbrepdc">Nbrepdc</Translate>
                </Label>
                <AvField id="borne-nbrepdc" type="string" className="form-control" name="nbrepdc" />
              </AvGroup>
              <AvGroup>
                <Label id="idpdcLabel" for="borne-idpdc">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.idpdc">Idpdc</Translate>
                </Label>
                <AvField id="borne-idpdc" type="string" className="form-control" name="idpdc" />
              </AvGroup>
              <AvGroup>
                <Label id="puissmaxLabel" for="borne-puissmax">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.puissmax">Puissmax</Translate>
                </Label>
                <AvField id="borne-puissmax" type="string" className="form-control" name="puissmax" />
              </AvGroup>
              <AvGroup>
                <Label id="typepriseLabel" for="borne-typeprise">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.typeprise">Typeprise</Translate>
                </Label>
                <AvField id="borne-typeprise" type="text" name="typeprise" />
              </AvGroup>
              <AvGroup>
                <Label id="accesrechargeLabel" for="borne-accesrecharge">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.accesrecharge">Accesrecharge</Translate>
                </Label>
                <AvField id="borne-accesrecharge" type="text" name="accesrecharge" />
              </AvGroup>
              <AvGroup>
                <Label id="accessibiliteLabel" for="borne-accessibilite">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.accessibilite">Accessibilite</Translate>
                </Label>
                <AvField id="borne-accessibilite" type="text" name="accessibilite" />
              </AvGroup>
              <AvGroup>
                <Label id="observationsLabel" for="borne-observations">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.observations">Observations</Translate>
                </Label>
                <AvField id="borne-observations" type="text" name="observations" />
              </AvGroup>
              <AvGroup>
                <Label id="datemajnoperateurLabel" for="borne-datemajnoperateur">
                  <Translate contentKey="jhipsterSampleApplicationApp.borne.datemajnoperateur">Datemajnoperateur</Translate>
                </Label>
                <AvInput
                  id="borne-datemajnoperateur"
                  type="datetime-local"
                  className="form-control"
                  name="datemajnoperateur"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.borneEntity.datemajnoperateur)}
                />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/borne" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  borneEntity: storeState.borne.entity,
  loading: storeState.borne.loading,
  updating: storeState.borne.updating,
  updateSuccess: storeState.borne.updateSuccess,
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(BorneUpdate);
