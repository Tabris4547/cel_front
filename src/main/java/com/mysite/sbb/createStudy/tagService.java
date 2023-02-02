package com.mysite.sbb.createStudy;
import com.mysite.sbb.DataNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class tagService {
    private final tagRepo tagReposi;
    public Tags getTag(Integer Id)
    {
        Optional<Tags> tag=this.tagReposi.findById(Id);
        if (tag.isPresent())
        {
            return tag.get();
        }
        else
        {
            throw new DataNotFoundException("Tag not found");
        }
    }

    public Tags create(Integer num,String tag1 ,String tag2,String tag3)
    {
        Tags tags =new Tags();
        tags.setStudyIdx(num);
        tags.setTagOne(tag1);
        tags.setTagTwo(tag2);
        tags.setTagThree(tag3);
        this.tagReposi.save(tags);
        return tags;
    }
}
