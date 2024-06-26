package com.br.mobiauto.management.schedule;

import com.br.mobiauto.management.model.OportunityDB;
import com.br.mobiauto.management.model.UserDB;
import com.br.mobiauto.management.service.OportunityService;
import com.br.mobiauto.management.service.UserDependencyService;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UpdateOpportunities {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateOpportunities.class);

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Autowired
    private UserDependencyService dependencyService;

    @Autowired
    private OportunityService oportunityService;

    @Transactional
    @Scheduled(cron = "${app.sched.cron}",zone = TIME_ZONE)
    @SchedulerLock(name = "atualizar oportunidades",lockAtMostFor = "PT6M",lockAtLeastFor = "PT5M")
    public void updateOportunities() {
        try{
            LOG.info("Atualizando oportunidades sem responsavel ");
            List<OportunityDB> opportunityWithoutResponsibility = oportunityService
                    .getOpportunityWithoutResponsibility();
            if (CollectionUtils.isEmpty(opportunityWithoutResponsibility)) {
                LOG.info("Nao ha oportunidades sem responsavel ");
                return;
            }
            opportunityWithoutResponsibility
                    .forEach(oportunity -> {
                        LOG.info("Atualizando oportunidade com id : {}", oportunity.getId());
                        UserDB responsible = dependencyService.getUserForResponsible();
                        LOG.info("Responsavel com id {} e com o cargo : {}", responsible.getId(),responsible.getPosition().getDescription());
                        oportunityService.assignResponsibleForSched(oportunity,responsible);
                    });
        }catch (Exception e){
            LOG.error("Erro ao atualizar oportunidades sem responsavel ", e.getMessage());
        }finally {
            LOG.info("Finalizando  job de atualização de oportunidades");
        }

    }
}
