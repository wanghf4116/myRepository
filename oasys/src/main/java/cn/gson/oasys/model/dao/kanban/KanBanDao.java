package cn.gson.oasys.model.dao.kanban;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.gson.oasys.model.entity.kanban.KanBan;

public interface KanBanDao extends JpaRepository<KanBan, Long>{

}
