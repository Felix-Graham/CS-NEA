!#/run/current-system/sw/bin/fish 
cd /home/rhemus/cs/Coursework/ 
echo "Making Zip Zone"
mkdir zipping_zone
echo ".java"
cp ~/cs/Coursework/CODE/*.java zipping_zone/
echo ".mp4"
cp ~/cs/Coursework/Development/'Stage 1'/screenshots/*.mp4 zipping_zone/
cp ~/cs/Coursework/Development/'Stage 2'/screenshots/*.mp4 zipping_zone/
cp ~/cs/Coursework/Development/'Stage 3'/screenshots/*.mp4 zipping_zone/
cp ~/cs/Coursework/Development/'Stage 4'/screenshots/*.mp4 zipping_zone/

echo ".pdf"
cp ~/cs/Coursework/*.pdf zipping_zone/
echo "zipping..."
zip -r result.zip zipping_zone/
echo "done"
rm -rf zipping_zone
