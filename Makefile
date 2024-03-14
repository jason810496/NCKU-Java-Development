STUDENT_ID=F74116720
TARGET=src META-INF

zip:
ifndef DIR
	$(error DIR is not set)
endif
	cd $(DIR) && zip -r $(STUDENT_ID).zip $(TARGET) && mv $(STUDENT_ID).zip ../
.PHONY: zip