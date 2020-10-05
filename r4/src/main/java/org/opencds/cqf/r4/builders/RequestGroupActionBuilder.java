package org.opencds.cqf.r4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.PlanDefinition;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.RelatedArtifact;
import org.hl7.fhir.r4.model.RequestGroup;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StringType;
import org.opencds.cqf.common.builders.BaseBuilder;

public class RequestGroupActionBuilder extends BaseBuilder<RequestGroup.RequestGroupActionComponent> {

    public RequestGroupActionBuilder() {
        super(new RequestGroup.RequestGroupActionComponent());
    }

    // TODO - incomplete

    public RequestGroupActionBuilder buildPrefix(String prefix) {
        complexProperty.setPrefix(prefix);
        return this;
    }

    public RequestGroupActionBuilder buildTitle(String title) {
        complexProperty.setTitle(title);
        return this;
    }

    public RequestGroupActionBuilder buildDescripition(String description) {
        complexProperty.setDescription(description);
        return this;
    }

    public RequestGroupActionBuilder buildDocumentation(List<RelatedArtifact> documentation) {
        complexProperty.setDocumentation(documentation);
        return this;
    }

    public RequestGroupActionBuilder buildRelatedAction(
            List<PlanDefinition.PlanDefinitionActionRelatedActionComponent> planDefinitionRelatedActions) {
        List<RequestGroup.RequestGroupActionRelatedActionComponent> requestGroupRelatedActions = new ArrayList<>();

        // Copy each PlanDefinition.RelatedAction into RequestGroup.RelatedAction
        for (PlanDefinition.PlanDefinitionActionRelatedActionComponent planDefinitionRelatedAction : planDefinitionRelatedActions) {
            String relationshipCode = planDefinitionRelatedAction.getRelationship().toCode();
            RequestGroup.ActionRelationshipType relationship = RequestGroup.ActionRelationshipType
                    .fromCode(relationshipCode);
            RequestGroup.RequestGroupActionRelatedActionComponent requestGroupRelatedAction = new RequestGroup.RequestGroupActionRelatedActionComponent();
            requestGroupRelatedAction.setActionId(planDefinitionRelatedAction.getActionId());
            requestGroupRelatedAction.setRelationship(relationship);
            requestGroupRelatedActions.add(requestGroupRelatedAction);
        }
        complexProperty.setRelatedAction(requestGroupRelatedActions);
        return this;
    }

    public RequestGroupActionBuilder buildType(CodeableConcept type) {
        complexProperty.setType(type);
        return this;
    }

    public RequestGroupActionBuilder buildResource(Reference resource) {
        complexProperty.setResource(resource);
        return this;
    }

    public RequestGroupActionBuilder buildResourceTarget(Resource resource) {
        complexProperty.setResourceTarget(resource);
        return this;
    }

    public RequestGroupActionBuilder buildExtension(String extension) {
        complexProperty.setExtension(Collections
                .singletonList(new Extension().setUrl("http://example.org").setValue(new StringType(extension))));
        return this;
    }

    public RequestGroupActionBuilder buildExtension(List<Extension> extensions) {
        complexProperty.setExtension(extensions);
        return this;
    }
}
