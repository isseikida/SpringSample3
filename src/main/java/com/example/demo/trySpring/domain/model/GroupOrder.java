package com.example.demo.trySpring.domain.model;

import javax.validation.GroupSequence;



//NO.2243 : グループの実行順序
@GroupSequence({ValidGroup1.class,ValidGroup2.class,ValidGroup3.class})
public interface GroupOrder {

}

