package com.cnu.motion.common.file;

import com.cnu.motion.common.type.PostType;
import com.cnu.motion.domain.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Transactional
    public void registerAttachments(PostType type, int postId, List<String> uploadedFiles) {
        for (String filePath : uploadedFiles) {
            Attachment attachment = new Attachment(type, postId, filePath);
            attachmentRepository.save(attachment);
        }
    }
}
