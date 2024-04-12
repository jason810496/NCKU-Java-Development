STUDENT_ID=F74116720
TARGET=src META-INF

zip:
ifndef HW
	$(error HW is not set)
endif
	cd $(HW) && zip -r $(STUDENT_ID).zip $(TARGET) && mv $(STUDENT_ID).zip ../
.PHONY: zip

dev:
ifndef HW
	$(error HW is not set)
endif
	cd $(HW)/src/ && javac $(HW).java && java $(HW)
.PHONY: zip

judge: zip
	./upload.sh $(STUDENT_ID) $(HW)
.PHONY: judge
