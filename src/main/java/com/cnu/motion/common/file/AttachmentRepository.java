package com.cnu.motion.common.file;

import com.cnu.motion.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
    void deleteAllByPostId(int postId);
}
